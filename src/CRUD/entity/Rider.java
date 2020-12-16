package CRUD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rider")
public class Rider {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="number")
	private String number;
	@Column(name="name")
	private String name;
	@Column(name="nation")
	private String nation;
	@Column(name="team")
	private String team;
	@Column(name="bike")
	private String bike;
	
	public Rider(String number, String name, String nation, String team, String bike) {
		this.number = number;
		this.name = name;
		this.nation = nation;
		this.team = team;
		this.bike = bike;
	}

	@Override
	public String toString() {
		return "Rider [id=" + id + ", number=" + number + ", name=" + name + ", nation=" + nation + ", team=" + team
				+ ", bike=" + bike + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getBike() {
		return bike;
	}

	public void setBike(String bike) {
		this.bike = bike;
	}

	public Rider() {
		
	}
}
