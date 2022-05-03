# Configure your own Wardrobe
Imagine you have just moved into your new apartment, and then you notice that you still need a new wardrobe for your dressing room. Regrettably, you won’t find a wardrobe that fits exactly to the size of your wall. But fortunately, the Swedish furniture dealer of your choice offers you the opportunity to build your own, customized wardrobe by combining individual wardrobe elements.

The wardrobe elements are available in the following sizes: 50cm, 75cm, 100cm, and 120cm. The wall on which the wardrobe elements are placed has a total length of 250cm. With which combinations of wardrobe elements can you make the most of the space?

Write a function that returns all combinations of wardrobe elements that exactly fill the wall.

## Additional Task
Here is the price list for the available wardrobe elements:

50cm => 59 USD

75cm => 62 USD

100cm => 90 USD

120cm => 111 USD

Write a second function that checks which of the resulting combinations is the cheapest one.

## Original:
https://kata-log.rocks/configure-wardrobe-kata


## Further idea
1. It might be better (better readability) if I would use another Object-Type (Wardrobe), which includes
an ArrayList<>() of Elements including their total price, so that I could determine the price easier.

2. I am getting duplicates: 
```
----Cheapest Combinations----
75 | 75 | 100 | -> 214 USD
75 | 100 | 75 | -> 214 USD
100 | 75 | 75 | -> 214 USD
```
This is not an problem since they are still possible combinations. It still is kinda redundant.