# MVCC的缺点
> MVCC在大多数情况下代替了行锁，实现了对读的非阻塞，读不加锁，读写不冲突。缺点是每行记录都需要额外的存储空间，需要做更多的行维护和检查工作。 要知道的，MVCC机制下，会在更新前建立undo log，根据各种策略读取时非阻塞就是MVCC，undo log中的行就是MVCC中的多版本。 而undo log这个关键的东西，记载的内容是串行化的结果，记录了多个事务的过程，不属于多版本共存。 这么一看，似乎mysql的mvcc也并没有所谓的多版本共存

## InnoDB的实现
1. 事务以**排他锁**的形式修改原始数据
2. 把修改前的数据存放于**undo log**，通过回滚指针与主数据关联
3. 修改成功（commit），数据放到**redo log**中，失败则恢复**undo log**中的数据（rollback）

