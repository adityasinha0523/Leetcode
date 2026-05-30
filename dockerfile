# Stage 1: Build stage

FROM python:3.10.12-bullseye AS builder

# Install dependencies
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        autoconf=2.69-14 \
        automake=1:1.16.3-2 \
        bash=5.1-2+deb11u1 \
        build-essential=12.9 \
        ca-certificates=20210119 \
        cmake=3.18.4-2+deb11u1 \
        curl=7.74.0-1.3+deb11u14 \
        g++=4:10.2.1-1 \
        gcc=4:10.2.1-1 \
        gfortran=4:10.2.1-1 \
        gnupg=2.2.27-2+deb11u2 \
        libblas-dev=3.9.0-3+deb11u1 \
        libboost-all-dev=1.74.0.3 \
        libffi-dev=3.3-6 \
        libopenblas-dev=0.3.13+ds-3+deb11u1 \
        libpq5=13.21-0+deb11u1 \
        libssl-dev=1.1.1w-0+deb11u2 \
        libtool=2.4.6-15 \
        llvm-dev=1:11.0-51+nmu5 \
        llvm-runtime=1:11.0-51+nmu5 \
        llvm=1:11.0-51+nmu5 \
        make=4.3-4.1 \
        musl-dev=1.2.2-1 \
        python3-pandas=1.1.5+dfsg-2 \
        unixodbc-dev=2.3.6-0.1+b1 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Ensure llvm-config is in the PATH
ENV PATH="/usr/lib/llvm/bin:${PATH}"

# Create and set working directory
WORKDIR /app

# Copy requirements file
COPY requirements.txt ./

# Install dependencies
RUN pip install --upgrade pip && \
    pip install --no-cache-dir --use-pep517 -r requirements.txt

# Copy only the app and config folders to the container
COPY app ./app
COPY config ./config

# Stage 2: Final stage
FROM python:3.10.12-slim-bullseye

# Install ODBC Driver 18 for SQL Server
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        curl=7.74.0-1.3+deb11u14 \
        gnupg=2.2.27-2+deb11u2 && \
    curl https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > /etc/apt/trusted.gpg.d/microsoft.asc.gpg && \
    curl https://packages.microsoft.com/config/debian/11/prod.list > /etc/apt/sources.list.d/mssql-release.list && \
    apt-get update && \
    ACCEPT_EULA=Y apt-get install -y --no-install-recommends \
        libgssapi-krb5-2=1.18.3-6+deb11u3 \
        libpq5=13.21-0+deb11u1 \
        msodbcsql18=18.5.1.1-1 \
        unixodbc-dev=2.3.11-3 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Create and set working directory
WORKDIR /app

# Copy dependencies from the builder stage
COPY --from=builder /usr/local/lib/python3.10/site-packages /usr/local/lib/python3.10/site-packages
COPY --from=builder /usr/local/bin /usr/local/bin

# Copy application code
COPY app ./app
COPY config ./config

# Create a non-root user first
RUN useradd --create-home --shell /bin/bash app_user

# Create logs directory and set permissions
RUN mkdir -p /app/logs && \
    chown -R app_user:app_user /app && \
    chmod -R 755 /app && \
    chmod 777 /app/logs

# Expose the port the app runs on
EXPOSE 8000

# Create a non-root user and set permissions
RUN useradd --create-home --shell /bin/bash app_user && \
    chown -R app_user:app_user /app && \
    chmod -R 777 /app/logs && \
    chmod -R 755 /app

# Switch to the non-root user
USER app_user

# Set environment variable for logging
ENV PYTHONUNBUFFERED=1
ENV LOG_DIR=/app/logs

# Command to run the application
CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]