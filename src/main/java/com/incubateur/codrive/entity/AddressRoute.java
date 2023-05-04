package com.incubateur.codrive.entity;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="addressroute")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRoute {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addRouId;
	@Length(max=5)
	private String rouPostalCodeStartPoint;
	@Length(max=5)
	private String rouPostalCodeEndPoint;
	@Length(max=100)
	private String rouStartCity;
	@Length(max=100)
	private String rouEndCity;
	@Length(max=150)
	private String rouStartPoint;
	@Length(max=150)
	private String rouEndPoint;
		
	private UUID uuid;
	@PrePersist
	public void prePersist(){
		this.uuid = UUID.randomUUID();
	}
			
}
