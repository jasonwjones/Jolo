## Jolo

Jolo is a Java ASCII table printing library with a focus on a tight but flexible API. It was designed to scratch an itch after searching around for something comparable in Java and finding really complex libraries with unwieldy APIs.

### Example

Let's take a look at some actual code. We want a table with three columns with fixed widths. We'll use Jolo's builder pattern to set up the table columns. Then for the purposes of this example we'll create some test data to print with, and finally, we'll print the actual table.

	public void testPrintTableWithColumns() {
	
		// setup table definition with column names/widths
		TableColumnList tcl = new TableColumnList.Builder()
			.add("Name", 40)
			.add("City", 15)
			.add("State", 2)
			.build();
			
		// createRandomRows is a helper function in this case but would otherwise
		// be your data that is an Iterable<List<Something>>.
		Iterable<List<? extends Object>> data = createRandomRows(10, 3);
		
		// create the printer and print the data
		TablePrinter tp = new TablePrinter();
		tp.outputTable(tcl, data);
	}
	
Note that while not seen here, the `createRandomRows()` routine just generates the number of rows we want with the number of columns we want, filling them in with random values. Here's what the output looks like:

    +----------------------------------------+---------------+--+
    |Name                                    |City           |St|
    +----------------------------------------+---------------+--+
    |n;l                                     |jhFDSmn;klq[   |;k|
    |klq[poias                               |a,.mzx;lk;:KLFl|x;|
    |.mz                                     |DSmn;klq[poiasd|mn|
    |x;lk;:KLF                               |a,.mzx;lk;:KLFl|Fl|
    |FDSmn;klq[poiasd;lkmnz.,xm              |a,.mzx;lk;:KLFl|kj|
    |hFDSmn;klq[poiasd;lkmnz.,xmn;l          |;:KLFlkjhFDSmn;|.m|
    |F                                       |zx;lk;:KLFlkjhF|LF|
    |q[poiasd;lkmnz.,xmn;l                   |:KLFlkjhFDSmn;k|,.|
    |,.mzx;lk;:KLFlkjhFDSmn;klq[poiasd;lkmnz.|,.mzx;lk;:KLFlk|a,|
    |lq[poiasd;                              |x;lk;:KLFlkjhFD|;l|
    +----------------------------------------+---------------+--+


### Holy awesome ASCII art batman!

Check out that sweet, sweet text table that evokes a simpler time from yesteryear. Here's some things to note:

  * A TablePrinter prints according to a given TableColumnList and the data you pass it. Although performance probably isn't a huge concern, this means that we think of the TP as an engine that doesn't intrinsically know about a table definition. In other words, it's our "heavy" object that we don't want to construct all of the time.
  
  * Having a TableColumnList data structure gives us a lot of flexibility with respect to printing. We can use different TablePrinter implementations as we see fit without having to redo code for defining what to print.
  
  * In other words, the TableColumn list is _what_ to print with respect to the table structure, the TablePrinter is _how_ to print, and the data is the data.
  
  * Using a Builder pattern for creating the TableColumnList is really nice because we can very easily define the definition of the columns and add convenience methods or a different builder in the future.
  
  * The TablePrinter takes an Iterable to print, so we don't have to pass around a huge array if we don't want to and we can get rows printing as they stream in. This could be useful, for example, if the data to be printed is taking awhile to fetch/calculate and we want to print as we get it.
  
  * There can be other TablePrinter implementations if we want to add them in the future. There's a DynamicTablePrinter class that's not quite ready for primetime but has some interesting features.
  
## License

Apache Software License version 2.