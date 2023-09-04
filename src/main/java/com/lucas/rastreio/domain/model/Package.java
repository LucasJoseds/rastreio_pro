// package com.lucas.rastreio.domain.model;

// import java.time.LocalDate;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// import org.springframework.data.annotation.Id;

// @Entity
// @Table(name="packages")
// public class Package {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.SEQUENCE)
//     private Long id;

//     private String code;

//     @ManyToOne
//     @JoinColumn(name="user_id")
//     private User user;

//     private LocalDate initDate;
    
//     private LocalDate finalDate;





//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getCode() {
//         return code;
//     }

//     public void setCode(String code) {
//         this.code = code;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public LocalDate getInitDate() {
//         return initDate;
//     }

//     public void setInitDate(LocalDate initDate) {
//         this.initDate = initDate;
//     }

//     public LocalDate getFinalDate() {
//         return finalDate;
//     }

//     public void setFinalDate(LocalDate finalDate) {
//         this.finalDate = finalDate;
//     }


    

// }
