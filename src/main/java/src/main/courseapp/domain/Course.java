package src.main.courseapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table

public class Course extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	private String cName;
	private String cDes;
	private String cPreq;
	@Enumerated(EnumType.STRING)
	private cSkillLevel level;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "cusers", joinColumns = @JoinColumn(name = "c_id", referencedColumnName = "cId"), inverseJoinColumns = @JoinColumn(name = "u_id", referencedColumnName = "uId"))
	private List<User> registeredUsers = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Topic> topics = new ArrayList<>();

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDes() {
		return cDes;
	}

	public void setcDes(String cDes) {
		this.cDes = cDes;
	}

	public String getcPreq() {
		return cPreq;
	}

	public void setcPreq(String cPreq) {
		this.cPreq = cPreq;
	}

	public cSkillLevel getLevel() {
		return level;
	}

	public void setLevel(cSkillLevel level) {
		this.level = level;
	}

	public List<User> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(List<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cDes=" + cDes + ", cPreq=" + cPreq + ", level=" + level
				+ "]";
	}
	

	

}
