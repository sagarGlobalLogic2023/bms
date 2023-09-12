package com.example.Book.my.show.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class userEntity {

	  public userEntity(String name, String email, String password, String role) {
			this.name = name;
			this.email = email;
			this.password = password;
			this.role = role;
		}

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @Column(nullable = false,unique = true, length=255)
	    private String name;

	    @Column(nullable= false, length=255)
	    private String email;
	    
	    @Column(nullable=false, length=255)
	    private String password;
	    
	    @Column(nullable=false, length=255)
	    private String role;
	    
	    @CreationTimestamp
	    @Temporal(value = TemporalType.TIMESTAMP)
	    private Date createdOn;

	    @UpdateTimestamp
	    @Temporal(value = TemporalType.TIMESTAMP)
	    private Date updatedOn;

	    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	    private List<TicketEntity> Tickets;


}
