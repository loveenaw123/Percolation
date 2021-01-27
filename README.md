# Percolation
Given a composite systems comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)? Scientists have defined an abstract process known as percolation to model such situations. 
# The model
We model a percolation system using an n-by-n grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row. In other words, a system percolates if we fill all open sites connected to the top row and that process fills some open site on the bottom row. (For the insulating/metallic materials example, the open sites correspond to metallic materials, so that a system that percolates has a metallic path from top to bottom, with full sites conducting. For the porous substance example, the open sites correspond to empty space through which water might flow, so that a system that percolates lets water fill open sites, flowing from top to bottom.)



![image](https://user-images.githubusercontent.com/51488834/105997916-fa748800-6060-11eb-9fe3-d9fc2d89dc3b.png)


Interactive Percolation visualiser allows user to select the sites in a grid of 10 X 10 like this

![image](https://user-images.githubusercontent.com/51488834/105998508-91d9db00-6061-11eb-88df-1c10caf2b943.png)


Percolation Visualizer prompts user to select the size of grid and enter the location of open sites on the basis of which it locates on the grid.



![image](https://user-images.githubusercontent.com/51488834/105999985-2d1f8000-6063-11eb-9424-40cb01852bd6.png)


![image](https://user-images.githubusercontent.com/51488834/106000395-9f906000-6063-11eb-812f-59df2fa6838a.png)


![image](https://user-images.githubusercontent.com/51488834/105999492-9e126800-6062-11eb-89c2-d7d5af7e5574.png)

Percolation Stats takes two command-line arguments n and T, performs T independent computational experiments on an n-by-n grid, and prints the sample mean, sample standard deviation, and the 95% confidence interval for the percolation threshold.







