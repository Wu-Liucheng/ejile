package xyz.somedefinitions.ejile.entity;



import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;



public class SuperAdmin extends Admin {
    private List<Business> businesses;

    public SuperAdmin(List<Business> businesses) {
        this.businesses = businesses;
    }

    public SuperAdmin(Integer id, String username, String password, Integer authority, Integer businessId, LocalDate createTime, LocalDate updateTime, Business business, List<Business> businesses) {
        super(id, username, password, authority, businessId, createTime, updateTime, business);
        this.businesses = businesses;
    }

    public SuperAdmin(@NotNull Admin admin, List<Business> businesses){
        this(admin.getId(),admin.getUsername(),admin.getPassword(),admin.getAuthority(),admin.getBusinessId()
        ,admin.getCreateTime(),admin.getUpdateTime(),admin.getBusiness(),businesses);
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}
