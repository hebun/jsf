// default package
// Generated Mar 8, 2014 1:06:30 PM by Hibernate Tools 3.4.0.CR1
package model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cart generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "cart", catalog = "clickcart")
public class Cart implements java.io.Serializable {

	private Integer id; 
	private Member member;
	private Integer bakiye;
	private String status;
	private String code;
	private String password;
	private String cartcol;
	private Set<Move> moves = new HashSet<Move>(0);

	public Cart() {
	}

	public Cart(Member member, Integer bakiye, String status, String code,
			String password, String cartcol, Set<Move> moves) {
		this.member = member;
		this.bakiye = bakiye;
		this.status = status;
		this.code = code;
		this.password = password;
		this.cartcol = cartcol;
		this.moves = moves;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name = "bakiye")
	public Integer getBakiye() {
		return this.bakiye;
	}

	public void setBakiye(Integer bakiye) {
		this.bakiye = bakiye;
	}

	@Column(name = "status", length = 45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "code", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "cartcol", length = 45)
	public String getCartcol() {
		return this.cartcol;
	}

	public void setCartcol(String cartcol) {
		this.cartcol = cartcol;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
	public Set<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(Set<Move> moves) {
		this.moves = moves;
	}

}