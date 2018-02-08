package me.xbones.essentialfeatures.API;

import me.xbones.essentialfeatures.gang.Gang;
import me.xbones.essentialfeatures.utils.TextUtils;
import me.xbones.essentialfeatures.utils.Utils;

import java.util.List;

// ESSENTIALFEATURES OFFICIAL API
public class EssentialFeaturesAPI {

    // VARIABLES //
    Utils utils = new Utils();
    // VARIABLES //

    // USE TO COLOR TEXT
    public String color(String message) {
        return TextUtils.color(message);
    }

    public List<Gang> getGangs() {
        return utils.getGangs();
    }

    public void saveGangs(List<Gang> gangs) {
        utils.saveGangsYML();
        utils.saveGangs(gangs);
    }

}
