### Spark 三大数据结构
- RDD：弹性分布式数据集
- 累加器：分布式共享只写变量
- 广播变量：分布式共享只读变量

### RDD 任务划分
RDD任务切分中分为：Application、Job、Stage和Task
- Application: 初始化一个SparkContext即生成一个Application；
- Job：一个Action算子就会生成一个Job；
- Stage：Stage等同于宽依赖（ShuffleDependency）的个数+1；
- Task：一个Stage阶段中，最后一个RDD的分区个数就是Task的个数
注意：Application >> Job >> Task 每一层都是1对N的关系。