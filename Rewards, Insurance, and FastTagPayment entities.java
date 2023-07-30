@Entity
@Table(name = "rewards")
public class Rewards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rewardType;

    // Add other reward-related fields as needed

    // Getters and setters, constructors, etc.
}

@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String insuranceType;

    // Add other insurance-related fields as needed

    // Getters and setters, constructors, etc.
}

@Entity
@Table(name = "fasttag_payment")
public class FastTagPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tagId;

    @Column(nullable = false)
    private Double amount;

    // Add other Fast Tag payment-related fields as needed

    // Getters and setters, constructors, etc.
}
public interface RewardsRepository extends JpaRepository<Rewards, Long> {
    // Add custom query methods if needed
}

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    // Add custom query methods if needed
}

public interface FastTagPaymentRepository extends JpaRepository<FastTagPayment, Long> {
    // Add custom query methods if needed
}
@Service
public class RewardsService {

    @Autowired
    private RewardsRepository rewardsRepository;

    // Implement service methods for rewards
}

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    // Implement service methods for insurance
}

@Service
public class FastTagPaymentService {

    @Autowired
    private FastTagPaymentRepository fastTagPaymentRepository;

    // Implement service methods for Fast Tag payments
}
@RestController
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    // Implement REST API endpoints for rewards
}

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    // Implement REST API endpoints for insurance
}

@RestController
public class FastTagPaymentController {

    @Autowired
    private FastTagPaymentService fastTagPaymentService;

    // Implement REST API endpoints for Fast Tag payments
}
