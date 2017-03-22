1. d2j-dex2jar classes.dex 反编译代码然后使用jd-gui查看生成的jar文件
2. apktool d Demo.apk 反编译资源
3. apktool b Demo -o New_Demo.apk 重新打包
4. 重新签名 jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 
-keystore 签名文件名 -storepass 签名密码 待签名的APK文件名 签名的别名
5. zipalign 4 New_Demo.apk New_Demo_aligned.apk 重新签名过后进行对齐操作

## proguard keep 关键字
- keep 保留类和类中的成员，防止它们被混淆或移除。
- keepnames 保留类和类中的成员，防止它们被混淆，但当成员没有被引用时会被移除。
- keepclassmembers 只保留类中的成员，防止它们被混淆或移除。
- keepclassmembernames 只保留类中的成员，防止它们被混淆，但当成员没有被引用时会被移除。
- keepclasseswithmembers 保留类和类中的成员，防止它们被混淆或移除，前提是指名的类中的成员必须存在，如果不存在则还是会混淆。
- keepclasseswithmembernames 保留类和类中的成员，防止它们被混淆，但当成员没有被引用时会被移除，前提是指名的类中的成员必须存在，如果不存在则还是会混淆。

## proguard 通配符
![image]proguard.png


