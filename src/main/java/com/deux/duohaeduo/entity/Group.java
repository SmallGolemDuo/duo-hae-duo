package com.deux.duohaeduo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "group_table")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @BatchSize(size = 5)
    @Builder.Default
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "group",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true
    )
    private Set<GroupMember> groupMembers = new HashSet<>();


    public void addGroupMembers(Set<GroupMember> groupMembers) {
        this.groupMembers.addAll(groupMembers);
    }

    public boolean containsGroupMemberId(Long groupMemberId) {
        for (GroupMember groupMember : this.getGroupMembers()) {
            if (groupMember.getId().equals(groupMemberId)) {
                return true;
            }
        }
        return false;
    }

    public void deleteGroupMember(Long groupMemberId) {
        this.groupMembers.stream()
                .filter(groupMember -> groupMember.getId().equals(groupMemberId))
                .findFirst()
                .ifPresent(toRemove -> {
                    this.groupMembers.remove(toRemove);
                    toRemove.setGroup(null);
                });
    }

}
