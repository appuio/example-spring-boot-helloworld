package ch.appuio.techlab.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@XmlRootElement
@Table(name = "hello", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Hello implements Serializable {
    /****/
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd.MM.yyyy HH:mm:ss", timezone="MET")
    private Date created;

	private String frontend = System.getenv("HOSTNAME");
	
	public Hello(){
		super();
	}
	
	public Hello(String name, Date created) {
		super();
		this.name = name;
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getFrontend() {
		return frontend;
	}

	public void setFrontend(String frontend) {
		this.frontend = frontend;
	}
}
