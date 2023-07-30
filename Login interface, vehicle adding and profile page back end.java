@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    // Getters and setters, constructors, etc.
}

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters and setters, constructors, etc.
}
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByUser(User user);
}
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Implement user registration logic (e.g., password hashing, username validation, etc.)
        // Save the user using userRepository.save(user)
    }

    public User loginUser(String username, String password) {
        // Implement user login logic (e.g., password verification, token generation, etc.)
        // Return the logged-in user or null if authentication fails
    }
}

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle, User user) {
        // Set the user for the vehicle and save it using vehicleRepository.save(vehicle)
    }

    public List<Vehicle> getUserVehicles(User user) {
        // Retrieve vehicles associated with the given user using vehicleRepository.findByUser(user)
        // Return the list of vehicles
    }
}
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Implement registration endpoint
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        // Implement login endpoint
    }
}

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle, Principal principal) {
        // Implement add vehicle endpoint
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserVehicles(Principal principal) {
        // Implement get user vehicles endpoint
    }
}
