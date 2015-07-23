@echo off
pushd "%~dp0"

:: -XX:MaxPermSize JVM option is not required if you are running on JVM 8+
:: -Dinput.encoding is neccessary to fix jline problems in SBT shell 

java -Xss2m -Xms2g -Xmx2g ^
  -XX:ReservedCodeCacheSize=256m ^
  -XX:+TieredCompilation ^
  -XX:+CMSClassUnloadingEnabled ^
  -XX:+UseNUMA ^
  -XX:+UseParallelGC ^
  -XX:MaxPermSize=256m ^
  -Dinput.encoding=Cp1252 ^
  -jar sbt-launch.jar %*

popd
