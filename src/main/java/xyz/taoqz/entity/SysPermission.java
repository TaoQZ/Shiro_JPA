package xyz.taoqz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
@Getter
@Setter
@Entity
@Table(name = "sys_permission")
public class SysPermission {
    @Id
    @GeneratedValue
    private Long id; // 主键.
    private String name; // 权限名称,如 user:select
    private String description; // 权限描述,用于UI显示
    private String url; // 权限地址.
    @JsonIgnoreProperties(value = {"permissions"})
    @ManyToMany
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles; // 一个权限可以被多个角色使用

    /** getter and setter */
}
