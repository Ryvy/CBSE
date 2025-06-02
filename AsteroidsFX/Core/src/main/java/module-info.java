module Core {
    uses dk.sdu.cbse.common.IEntityProcessing;
    uses dk.sdu.cbse.common.IPlugin;
    uses dk.sdu.cbse.common.IEntityPostProcessing;
    opens dk.sdu.mmmi.cbse.core to spring.core;
    requires javafx.graphics;
    requires Common;
    requires jdk.compiler;
    requires spring.context;
    requires spring.beans;
    exports dk.sdu.mmmi.cbse.core;
}