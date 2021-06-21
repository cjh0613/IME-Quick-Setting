# IME-Quick-Setting
最近换了iqoo手机，发现系统阉割了切换输入法通知，改成长按输入框，然后点击“输入法”切换。
但是微信之类的应用魔改了输入框的弹出菜单，导致长按无法切换输入法，很不方便。
所以写了这个小工具，通过添加一个"Quick settings tile"到状态栏，实现快速切换输入法

## 使用方法
1. 下载安装[apk](https://github.com/licheedev/IME-Quick-Setting/releases)
2. 手机开启开发者选项，并adb连接到电脑
3. （可选）Android P(9)或之前版本的话，执行下面的命令（获取权限，在任何界面切换输入法）
```bash
adb shell pm grant com.licheedev.imeqs android.permission.WRITE_SECURE_SETTINGS
```
## 截图

| ![快捷按钮](https://raw.githubusercontent.com/licheedev/IME-Quick-Setting/main/files/device-2021-06-21-152856.png)  | ![切换界面](https://raw.githubusercontent.com/licheedev/IME-Quick-Setting/main/files/device-2021-06-21-152825.png)  |
| ---- | ---- |



