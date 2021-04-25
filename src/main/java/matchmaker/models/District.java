package matchmaker.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum District {
    Amravati, Yavatmal, Akola, Wardha, Nagpur, Washim, Buldhana, Nanded;

    public List<District> getNearbyDistricts() {
        switch(this){
            case Amravati:
            case Nanded:
            case Buldhana:
                return  Arrays.asList(Yavatmal, Akola, Wardha, Washim);
            case Yavatmal: return Arrays.asList(Amravati, Wardha, Washim, Nanded);
            case Akola: return  Arrays.asList(Amravati, Buldhana, Washim);
            case Wardha: return  Arrays.asList(Yavatmal, Amravati, Nagpur);
            case Nagpur: return  Collections.singletonList(Wardha);
            case Washim: return  Arrays.asList(Yavatmal, Akola, Amravati, Nanded);
            default: return Collections.emptyList();
        }
    }
}
