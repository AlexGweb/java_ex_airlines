@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Email
    private String email;
    
    private String password;
    
    @Enumerated(EnumType.STRING)
    private UserRole role;
} 