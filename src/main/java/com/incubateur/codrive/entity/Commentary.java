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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="commentary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commentary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Length(min=0,max=500)
	@NotBlank
	private String text;
	@Min(value=0)
	@Max(value=5)
	private Double note;
	@PastOrPresent
	private LocalDate datePublication;
	@ManyToOne
	@JoinColumn(name="rou_id")
	private Route route;
	@ManyToOne
	@JoinColumn(name="use_id")
	private User user;
	
	private UUID uuid;
	@PrePersist
	public void prePersist(){
		this.uuid = UUID.randomUUID();
	}
	
}
