# Eclipse Setup
You've got a decision to make here. To one hand you have 
downloading the Scala IDE bundle including eclipse, on the other you can 
manually install some plugins in your current Eclipse installation.
 
#### The Bundle Way
1) Head to http://scala-ide.org/
2) Click Download -> Scala IDE
3) Follow installation instructions
4) Job done

#### The Plugins Way
1) Head to http://scala-ide.org/
2) Click Download -> Latest Stable and copy the update site URL
3) Open up your current Eclipse installation
4) Navigate to Help -> Install New Software...
5) Click Add...
6) Give the Repo a name, something like "Scala IDE" and then paste in the 
update site URL
7) Install the following plugins and restart Eclipse:
    * Scala IDE for Eclipse
    * ScalaTest for Scala IDE
    * Play 2 support    
    
#### Opening the Project
1) In a terminal/command prompt navigate to the root of this project
2) Run the following to generate the eclipse project files:
    ```
        sbt eclipse
    ```
3) Open your project in Eclipse using File -> Import -> General ->
Existing Projects into Workspace and selecting this projects directory