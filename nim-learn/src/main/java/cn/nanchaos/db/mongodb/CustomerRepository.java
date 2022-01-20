package cn.nanchaos.db.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author nanchaos
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

  public Customer findByFirstName(String firstName);
  public List<Customer> findByLastName(String lastName);

}