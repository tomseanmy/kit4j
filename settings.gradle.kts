plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "kit4j"
include("util")

include("wechat:wechat-pay")
findProject(":wechat:wechat-pay")?.name = "wechat-pay"
include("wechat:wechat-dev")
findProject(":wechat:wechat-dev")?.name = "wechat-dev"