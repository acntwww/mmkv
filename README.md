# mmkv

使用 kotlin 委托属性封装的 mmkv 库，代替 SharedPreferences，简单好用

- 支持基本类型：int/long/float/double/boolean
- 支持对象类型：字符串，字符串集合，字节数组
- 支持可空对象类型：字符串，字符串集合，字节数组
- 支持Parcelable类型

## 引入

### Maven Central / Local Repository

``` groovy
repositories {
    mavenCentral()
    // 或者本地仓库
    // maven { url "https://gitee.com/ezy/repo/raw/cosmo/"}
}
dependencies {
    implementation "me.reezy.cosmo:mmkv:0.7.0"
}
```

### 从源码构建和发布

``` bash
# 构建库
./gradlew :mmkv:build

# 发布到本地 Maven 仓库
./gradlew :mmkv:publishToMavenLocal

# 发布到自定义仓库
./gradlew :mmkv:publish
```

## 使用

委托属性添加在实现了 MMKVOwner 的类上，委托属性的值存储在从 MMKVOwner 获取的 MMKV 实例中

否则存储在默认的 MMKV 实例中

``` kotlin
class SomeActivity : Activity {

    // 委托属性的值存储在默认的 MMKV 实例中
    private var isFirstLaunch by mmkvBoolean(default = true)


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // 赋值
        isFirstLaunch = false

        // 判断
        if (isFirstLaunch) {
            // todo
        }
    }
}
```


``` kotlin
object SomeManager {
    private object store : MMKVOwner {
        // store 对象的委托属性的值存储此 MMKV 实例中
        override val mmkv: MMKV = MMKV.mmkvWithID("some")

        var intValue by mmkvInt()
        var longValue by mmkvLong()
        var floatValue by mmkvFloat(0f)
        var booleanValue by mmkvBoolean(false)
        var stringValue by mmkvString("some")
        var nullableStringValue by mmkvNullableString()
    }
}
```

## Maven 发布

该项目支持 Maven 发布功能，包含以下发布选项：

### 可用的发布任务

- `publishToMavenLocal` - 发布到本地 Maven 缓存
- `publishMavenPublicationToLocalRepository` - 发布到自定义本地仓库
- `publish` - 发布到所有配置的仓库

### 发布配置

发布配置包括：
- **Group ID**: `me.reezy.cosmo`
- **Artifact ID**: `mmkv`
- **Version**: `0.7.0`

发布的工件包括：
- Main JAR (库代码)
- Sources JAR (源代码)
- Javadoc JAR (文档)
- POM 文件 (依赖信息)
- Gradle Module Metadata

### 自定义发布仓库

可以通过在 `gradle.properties` 中配置 `cosmoRepoPath` 来指定自定义发布仓库：

```
cosmoRepoPath=https://your-maven-repo.com/repository/
```

## LICENSE

The Component is open-sourced software licensed under the [Apache license](LICENSE).