2.使用场景
当在一个分支开发功能开发到一半要进行合并代码或者切换分支操作，这时候就可以把现有工作区域的代码暂存起到git栈，然后进行合并或者切换分支的操作，等操作完后要继续之前未完成的，这时候git stash就派上用场，真的太方便了、
---


1.git stash list
查看当前stash的所有内容

2.git stash
保存当前的工作区与暂存区的状态，把当前的修改的保存到git栈，等以后需要的时候再恢复，git stash 这个命令可以多次使用，每次使用都会新加一个stash@{num} num是编号

3.git stash save '注释'
作⽤等同于git stash，区别是可以加⼀些注释， 执⾏存储时，添加注释，⽅便查找
git stash save 'test'

4.git stash pop
默认恢复git栈中最新的一个stash@{num}，建议在git栈中只有一条的时候使用，以免混乱，该命令将堆栈中最新保存的内容删除

5、git stash apply
将堆栈中的内容恢复到当前分支下。这个命令不同于 git stash pop。该命令不会将内容从对堆栈中删除，也就是该命令能够将堆栈的内容多次运用到工作目录，适合用与多个分支的场景
git stash apply stash@{$num}

6、git stash drop
从堆栈中移除指定的stash
git stash drop stash@{$num}

7、git stash clear
移除全部的stash

8、git stash show
查看堆栈中最新保存的stash和当前⽬录的差异