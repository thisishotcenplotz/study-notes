### Why is Scala?
- Spark 新一代内存级大数据计算框架，是大数据的重要内容。
- Spark 就是使用Scala编写的。因此为了更好的学习Spark，需要掌握rScala这门语言。
- Scala是Scalable Language的简写，是一门多范式（编程的方式【面相对象、函数式】）的变成语言
- 联邦理工洛桑学院的 Martin Odersky于2001年开始设计Scala
- Spark的兴起，带动个Scala语言的发展！

### Scala语言诞生小故事
创始人Martin Odersky是编译器及编程的狂热爱好者，长时间的编程之后，希望发明一种语言，能够让写程序这样的基础工作变得搞高效简单。所以当接触到Java语言后，对Java这门便携式，运行在网络，且存在垃圾回收的语言产生了极大的兴趣，所以决定将函数式语言的特点融合到Java中，由此发明了（Scala&Pizza）

### Scala, Java以及JVM的关系
一般来说，学Scala的人，都会Java，而Scala是基于Java的，因此我们需要将Scala和Java以及JVM之间的关系搞清楚。
- 使用scala的sdk（Java：jdk），同时会用到JDK
- 支持部分Java语法
- 拥有Scala特定语法
- 增加功能，比如函数式编程
  - 偏函数
  - 函数的柯里化
  - 高阶函数
  - 将函数作为参数传递
- 从形式上看，是scala的类，但这个类是对Java的类进行接口包装
- 都跑在JVM上

### Scala语言的特点
Scala是一门以JVM为运行环境并将面向对象和函数式变成的最佳特性结合在一起的静态类型编程语言
1. Scala是一门多范式（multi-paradigm）的编程语言，Scala支持面向对象和函数式
2. Scala源代码（.scala）会被编译成Java字节码（.java）然后运行于JVM之上，并可以调用现有的Java类库，实现两种语言的无缝对接。
3. Scala单作为一门语言来看，非常高简洁高效
4. Scala在设计时，Martin Odersky 参考了Java的设计思想，可以说Scala是源于Java，同时Mardin也加入了自己的思想，将函数式编程语言的特点融合到Java中，因此对于学习过Java的人，只要在学习Scala的过程中，搞清楚Scala和Java的相同点和不通电，就可以快速掌握Scala这门语言

### Scala数据类型
1. Scala与Java有着相同的数据类型，在Scala中数据类型都是对象，也就是说Scala没有Java中的原生类型
2. Scala数据类型分为两大类 AnyVal 和 AnyRef
3. 相对于Java的类型系统，Scala要复杂些，也正是这复杂多变的类型系统才让面向对象编程和函数式变成完美融合在了一起
4. Any
	- AnyVal
		- Double
		- Float
		- Long
		- Int
		- Short
		- Byte
		- Boolean
		- Char
		- StringOps
		- Unit
	- AnyRef
		- Scala collections
		- Other Scala classes
		- all java classes
5. 整理
   - 在Scala中有一个根类型Any，他是所有类的父类
   - Scala中一切皆为对象，分为两大类AnyVal和AnyRef，他们都是Any的子类
   - Null类型是Scala的特别类型，它知识一个值null，他是bottom class，所有AnyRef类型的子类
   - Nothing类型也是bottom class，他是所有类的子类，在开发中通常可以将Nothing类型的值返回给任意变量或者函数，在抛出异常中使用较多

### 隐式转换
当Scala程序进行赋值或运算时，精度小的类型自动转换为精度大的类型，这个就是自动类型转换（隐式转换）

### 函数式变成
在Scala中将方法、函数、函数式变成和面向对象编程明确一下：
1. 在Scala中，方法和函数几乎可以等同（比如它们的定义、使用、运行机制都一样），知识函数的使用方式更加的灵活多样（方法转函数）
2. 函数式变成是从编程方式（范式）的角度来谈的，可以这样理解：函数式变成把函数当成一等公民，充分利用函数、支持的函数的多种使用方式。
比如：在Scala中，函数时一等公民，像变量一样，既可以作为函数的参数使用，也可以将函数赋值给一个变量。函数的创建不用依赖于类或者对象，而在Java中，函数的创建则依赖于类、抽象类或接口
3. 面相对象编程是以对象为基础的编程方式
4. 在Scala中函数式和面向对象编程融合在一起了
































