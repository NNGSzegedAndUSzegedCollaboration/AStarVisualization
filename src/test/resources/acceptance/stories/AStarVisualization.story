A* visualization

Narrative:
In order to make the presentation awesome
As a presenter of the A* algorithm
I want to have a software that is able to visualize the running of A* 
					 
Scenario:  Running A* on a small graph
Given a graph Map
And a node Szeged at 46.253170, 20.150205
And a node Hódmezővásárhely at 46.414691, 20.318424
And a node Makó at 46.215120, 20.478761
And a node Orosháza at 46.557642, 20.670273
And a node Békéscsaba at 46.680143, 21.098212
And an edge between Szeged and Hódmezővásárhely that takes 25 min
And an edge between Hódmezővásárhely and Orosháza that takes 29 min
And an edge between Orosháza and Békéscsaba that takes 34 min
And an edge between Szeged and Makó that takes 30 min
And an edge between Makó and Békéscsaba that takes 63 min
And an edge between Makó and Orosháza that takes 46 min
And an edge between Makó and Hódmezővásárhely that takes 27 min
When A* is run to find the shortest path from Szeged to Békéscsaba
Then it returns the path through Szeged, Hódmezővásárhely, Orosháza, Békéscsaba
