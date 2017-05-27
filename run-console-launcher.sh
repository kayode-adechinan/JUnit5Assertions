#!
# Run console launcher. This (very) simple script provided
# as a convenience. Make sure to change this script if any
# dependencies change in the POM or build.gradle.
#
#
CONSOLE_LAUNCHER_JAR_ROOT=./target/lib
echo CONSOLE_LAUNCHER_JAR_ROOT=${CONSOLE_LAUNCHER_JAR_ROOT}
#
CONSOLE_LAUNCHER_JAR=junit-platform-console-standalone-1.0.0-M4.jar
echo CONSOLE_LAUNCHER_JAR=${CONSOLE_LAUNCHER_JAR}
#
LIB_ROOT=./target/lib
echo LIB_ROOT=${LIB_ROOT}
#
DEPENDENT_JAR_CLASSPATH=${LIB_ROOT}/junit-platform-runner-1.0.0-M4.jar:${LIB_ROOT}/commons-lang3-3.5.jar
echo DEPENDENT_JAR_CLASSPATH=${DEPENDENT_JAR_CLASSPATH}
#
TEST_CLASSES_ROOT=./target/classes:./target/test-classes/
echo TEST_CLASSES_ROOT=${TEST_CLASSES_ROOT}
#
#EXCLUDE_TAGS='--exclude-tag advanced --exclude-tag someothertag'
echo EXCLUDE_TAGS=${EXCLUDE_TAGS}
#
echo Running Maven build to get things set up...
# Skip tests... don't worry, we will be running them soon enough!
mvn clean package -DskipTests
#
echo Starting console launcher...
echo ""
echo ""
java -jar ${CONSOLE_LAUNCHER_JAR_ROOT}/${CONSOLE_LAUNCHER_JAR} \
--scan-class-path \
--class-path ${TEST_CLASSES_ROOT}:${DEPENDENT_JAR_CLASSPATH} \
${EXCLUDE_TAGS}