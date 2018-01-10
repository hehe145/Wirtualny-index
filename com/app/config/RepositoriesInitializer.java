package com.app.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoriesInitializer {

/*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    InitializingBean init() {

        return () -> {
            if(userRepository.findAll().isEmpty()) {

                Role roleUser = new Role(Role.Types.ROLE_USER);
                Role roleAdmin = new Role(Role.Types.ROLE_ADMIN);
                roleRepository.save(roleUser);
                roleRepository.save(roleAdmin);

                User admin = new User("admin", true);
                admin.setEmail("patrykrafal33@o2.pl");
                admin.setRoles(new HashSet<>(Arrays.asList(roleAdmin)));
                admin.setPassword(passwordEncoder.encode("admin"));

                userRepository.save(admin);

            }

        };
    }
*/
}

