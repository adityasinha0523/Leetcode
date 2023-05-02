# Leetcode Solution
<h3>Homework #2: HeatMap Charts and Adding Interactivity</h3>

<br>
<p>The purpose of this homework is to give you practice interactively building and linking visualizations together in D3. By the end of this assignment you should be able to:</p>

<ul>
<li>Dynamically create and parse a number dataset in JavaScript</li>
<li>Visualize the values in a bar and heatmap chart</li>
<li>Dynamically update a chart based on user interactions</li>
<li>Add an interactive tooltip</li>
</ul>

The screenshot below shows an example of what your finished interface will look like.
<img href a="images/"></a>

## Overview

The starter code for this assignment shows three panels on the `index.html` page. The top panel contains a `textarea` html element and a `submit` button. The user can enter a set of text and then click the button. This should create a heatmap chart in the bottom panel. The heatmap chart will visualize the distribution of the entered text number based on their type (i.e. numbers coming at ones place,tens place,hundred place and thousand place). Hovering over a heatmap will show the counts of the selected number.

## Data Description

The text entered into the `textarea` element will consitute the data for your visualizations. You should assume that the entered characters will be of the following types. 
- numbers between 0 to 99999.



As an example, if the user submits the following as their text:

```html
 10,20,100,200,5,9,1567
```

You would count the number of times each vowel appears in the submitted text:

```
Value at ones place:
0:4
1:0
2:0
3:0
4:0
5:1
6:0
7:1
8:0
9:1

Value at tens place:
0:2
1:1
2:1
3:0
4:0
5:0
6:1
7:0
8:0
9:0

Value at hundred place:
0:0
1:1
2:1
3:0
4:0
5:1
6:0
7:0
8:0
9:0

Value at thousand place:
0:0
1:1
2:0
3:0
4:0
5:0
6:0
7:0
8:0
9:0

Value at ten thousand place:
0:0
1:0
2:0
3:0
4:0
5:0
6:0
7:0
8:0
9:0
 ```
