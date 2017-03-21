package com.sodevan.bhamaheal.Models;

/**
 * Created by ronaksakhuja on 21/03/17.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BhamData {

    @SerializedName("hof_Details")
    @Expose
    private HofDetails hofDetails;
    @SerializedName("family_Details")
    @Expose
    private List<FamilyDetail> familyDetails = null;

    public HofDetails getHofDetails() {
        return hofDetails;
    }

    public void setHofDetails(HofDetails hofDetails) {
        this.hofDetails = hofDetails;
    }

    public List<FamilyDetail> getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(List<FamilyDetail> familyDetails) {
        this.familyDetails = familyDetails;
    }
}
