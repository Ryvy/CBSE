module Core {
    uses dk.sdu.cbse.common.IEntityProcessing;
    uses dk.sdu.cbse.common.IPlugin;
    uses dk.sdu.cbse.common.IEntityPostProcessing;
    requires javafx.graphics;
    requires Common;
    requires jdk.compiler;
    exports dk.sdu.mmmi.cbse.core;
}