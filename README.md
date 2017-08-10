# GpuHelperForBurst
A program that makes life easier for plotting with GpuPlotter.

How to use:

0. compile it as jar file. or download it from my google drive https://drive.google.com/open?id=0ByZPs5ckrlVmTFp0TkpONEJmWnc
1. place it in the same folder as GpuPlotter. At the time of this writing it was tested on 4.1.1. 
   (https://github.com/bhamon/gpuPlotGenerator/releases)
2. Run it by double click or in console by typing "java -jar gpuPlotterHelper"
3. Select hddr to plot, how many bytes it should plot, how many nonces you want to write in one go, starting nonce,
   your BURST numeric id and how much ram your machine has.
4. click "Create .bat Files"
5. close the GpuPlotterHelper
6. Run X_hdd_Plotter_Start_me.bat and leave it running. If uninterrupted it should finish with no problems.
7. move plotted files into Burst/plots file on your hddr.

thats it.


What does the helper do?
-It saves you the time and energy finding parameters to pass to gpuPlotter. It creates several .bat files which are instructions with
  correct arguments for gpuPlotter.
  These files are named "<Your hdd label>plot_<number>" where number represents their order.
  for example Dplot_0 and Dplot_1 both each makes a plot file on D drive. The starting nonce of Dplot_1 is 1 higher than where Dplot_0's end.
  
  The X_hdd_Plotter_Start_me.bat simply runs the aforementioned Xplot_Y files in succession and keeping a very basic log
  of what it ran and what it finished into logX.txt file, where the X stands for the label of the drive being plotted.
  After each successfull plotting of a Xplot_Y.bat file the Xplot_Y.bat file is deleted. So if you see that the program
  started working on a plot file and never finished it, it means it got corrupted. You manually have to go into hdd and
  delete the file and then run the X_hdd_Plotter_Start_me.bat again. The log will be overwritten every time the X_hdd_Plotter_Start_me.bat
  is run.

  I'm sure the code has some bugs, feel free to fork and do whatever you wish with it as long as it remains free.

  
