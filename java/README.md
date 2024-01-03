更新于20240103

#### poi处理excel的基础知识

> POI提供了HSSF、XSSF以及SXSSF三种方式操作Excel。
>
> HSSF：Excel97-2003版本，扩展名为.xls。一个sheet最大行数65536，最大列数256。
>
> XSSF：Excel2007版本开始，扩展名为.xlsx。一个sheet最大行数1048576，最大列数16384。
>
> SXSSF：是在XSSF基础上，POI3.8版本开始提供的支持低内存占用的操作方式，扩展名为.xlsx。

#### poi读取excel

> poi读取xls后缀的excel文件，使用HSSFWorkbook
>
> poi读取xlsx后缀的excel文件，使用XSSFWorkbook
>
> poi读取xlsx后缀的excel文件，使用SXSSFWorkbook，依赖XSSFWorkbook