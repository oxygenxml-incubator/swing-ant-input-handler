# Swing Apache Ant Input Handler
Implementation of the Ant Input Handler interface

Implementation of the https://ant.apache.org/manual/inputhandler.html API which shows a dialog allowing the end user to choose the value.
If you are running Ant from inside Oxygen:
  - Edit the transformation scenario.
  - In the "Options" tab:
    - Set the Additional Ant arguments field to the value (without quotes) "-inputhandler com.oxygenxml.ant.inputhandler.SwingInputHandlerImpl"
    - Add in the JVM Arguments field the value (without quotes) "-Djava.awt.headless=false"
    - Click the "Libraries" tab and add a reference to the library "swing-input-handler.jar"
   
For example if the following ANT build file is run:

        <project basedir="." name="" default="abc">
          <target name="abc">
              <input message="Continue?"
                  validargs="Yes,Other,Cancel" addproperty="do.continue" defaultvalue="Other"/>
              <echo>${do.continue}</echo>
          </target>
        </project>

the end user will be shown a dialog with a combo box allowing them to choose one of the proposed valid arguments. The default value will be selected in the combo box.
