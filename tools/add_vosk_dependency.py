import re
p='app/build.gradle'
s=open(p, encoding='utf-8').read()
if "com.alphacephei:vosk-android" not in s:
    if "dependencies {" in s:
        s=s.replace("dependencies {", "dependencies {
    implementation 'com.alphacephei:vosk-android:0.3.75'", 1)
    else:
        s += "

dependencies {
    implementation 'com.alphacephei:vosk-android:0.3.75'
}
"
open(p,'w',encoding='utf-8').write(s)
print('VOSK_NATIVE_DEPENDENCY_ADDED')
