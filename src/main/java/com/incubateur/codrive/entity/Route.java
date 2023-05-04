package com.incubateur.codrive.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@FutureOrPresent
	//@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateStarting;
	@Length(min = 0,max = 9)
	private Integer nbrPlaceAvailable;
	@Min(value=0)
	@Max(value=20)
	private Integer nbrBigBaggage;
	@Min(value=0)
	@Max(value=20)
	private Integer nbrSmallBaggage;
	@Min(value = 1)
	private Integer price;
	@ManyToOne
	@JoinColumn(name="use_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	@ManyToOne
	@JoinColumn(name="add_rou_id")
	private AddressRoute addressRoute;
	
	private UUID uuid;
	@PrePersist
	public void prePersist(){
		this.uuid = UUID.randomUUID();
	}
	
	
}
