package me.phoenixra.visorexample.core.client.overlays;

import me.phoenixra.atumvr.api.misc.color.AtumColor;
import me.phoenixra.visor.api.client.data.PoseAnchor;
import me.phoenixra.visor.api.client.gui.overlay.template.RegisterVROverlayTemplate;
import me.phoenixra.visor.api.client.gui.overlay.template.framework.VROverlayTemplateScreen;
import me.phoenixra.visor.api.client.gui.overlay.template.options.OverlayOptions;
import me.phoenixra.visor.api.client.gui.overlay.template.options.types.OverlayOptionsGlobal;
import me.phoenixra.visor.api.client.gui.overlay.template.options.types.OverlayOptionsLocation;
import me.phoenixra.visor.api.common.addon.VisorAddon;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@RegisterVROverlayTemplate(id = VROverlayTemplateExample.ID)
public class VROverlayTemplateExample extends VROverlayTemplateScreen {
    public static final String ID = "template_example";

    private final Component text = Component.literal("Template Overlay Example");

    public VROverlayTemplateExample(@NotNull VisorAddon owner, @NotNull String id) {
        super(owner, id);
        //if you want it to be enabled once created
        setEnabled(true);
    }

    @Override
    protected void onRender(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        guiGraphics.drawCenteredString(this.font, text,
                width/2, height/2, AtumColor.WHITE.toInt());

    }

    @Override
    protected boolean updateVisibility() {
        return true;
    }


    @Override
    protected @NotNull List<OverlayOptions> createOptions() {
        return List.of(
                new OverlayOptionsGlobal(
                        this,
                        it->{
                            it.setUpdateOptionsType(OverlayOptionsGlobal.UpdateOptionsType.TICK);
                            it.setFormulaOverlayScale("1.0");
                        }
                ),
                new OverlayOptionsLocation(
                        this,
                        it->{
                            it.setTickModelView(true);
                            it.setAimRotation(false);
                            it.setPositionAnchor(PoseAnchor.HMD);
                            it.setFormulaPosX(null);
                            it.setFormulaPosY("-0.1");
                            it.setFormulaPosZ("-1.2");
                            it.setRotationAnchor(PoseAnchor.HMD);
                            it.setFormulaRotationX(null);
                            it.setFormulaRotationY(null);
                            it.setFormulaRotationZ(null);
                        }

                )
        );
    }
}
