# richeditor
http://www.cnblogs.com/qianxudetianxia/p/4322331.html
https://bintray.com/
https://crosswalk-project.org/documentation/android/embedding_crosswalk_rvw.html
https://download.01.org/crosswalk/releases/crosswalk/android/stable/
#arr上传
gradle javadocJar
gradle  sourcesJar
gradle  install
gradle  bintrayUpload

集成：
在modle gradle 文件中添加以下代码：
repositories {
    maven {
        url 'https://dl.bintray.com/longqiankun/maven/'

    }
    maven {
        url 'https://download.01.org/crosswalk/releases/crosswalk/android/maven2'

    }
}

 compile 'com.lqk.richeditor:richeditcore:0.2'