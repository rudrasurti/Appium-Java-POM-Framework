XML=$1
Device=$2
apk_name=$3

mvn --version
mvn test-compile compile
echo "Deploying to BrowserStack for Android with a test suite named '$XML' on the device '$Device' with apk = '$apk_name'"

IFS=',' read -ra values <<< "$Device"

# Iterate over each value using a for loop
for value in "${values[@]}"; do
    echo "Running on: $value"
    mvn surefire:test -DplatformName=browserStack -Dsurefire.suiteXmlFiles="src/test/resources/runners/Browserstack/$XML" -DdeviceName="$value" -DandroidAppLocation="/app/$apk_name"
done