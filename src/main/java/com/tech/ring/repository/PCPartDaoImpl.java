package com.tech.ring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Game;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.User;
import com.tech.ring.domain.Vga;
import com.tech.ring.request.NotificationRequest;
import com.tech.ring.domain.Notification;

@Repository
public class PCPartDaoImpl implements PCPartDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Ram saveRam(Ram pcpart) {
		try {
			mongoTemplate.save(pcpart);
			return pcpart;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public List<Ram> findByRamPartByName(String partName) {
		try {
			
			if(partName.equals("all")) {
				return mongoTemplate.findAll(Ram.class);
			}
			else {
				Query query = new Query();
				query.addCriteria(Criteria.where("name").is(partName));
				
				List<Ram> rams = mongoTemplate.find(query, Ram.class);
				return rams;
			}
			
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Ram findByRamPartById(String id) {

		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			
			return mongoTemplate.findOne(query, Ram.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Ram> findRamVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.find(query, Ram.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Vga> findByVgaPartByName(String partName) {
		try {
			
			if(partName.equals("all")) {
				return mongoTemplate.findAll(Vga.class);
			}
			else {
				Query query = new Query();
				query.addCriteria(Criteria.where("name").is(partName));
				
				return mongoTemplate.find(query, Vga.class);
			}
			
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Vga findByVgaPartById(String id) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			
			return mongoTemplate.findOne(query, Vga.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Vga> findVgaVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.find(query, Vga.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Vga saveVga(Vga pcpart) {
		try {
			mongoTemplate.save(pcpart);
			return pcpart;
		} catch (Exception e) {
			
			return null;
		}
	}


	@Override
	public List<Cpu> findByCpuPartByName(String partName) {
		try {
			
			if(partName.equals("all")) {
				return mongoTemplate.findAll(Cpu.class);
			}
			else {
				Query query = new Query();
				query.addCriteria(Criteria.where("name").is(partName));
				
				return mongoTemplate.find(query, Cpu.class);
			}
			
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Cpu findByCpuPartById(String id) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			
			return mongoTemplate.findOne(query, Cpu.class);
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<Cpu> findCpuVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.find(query, Cpu.class);
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Cpu saveCpu(Cpu pcpart) {
		try {
			mongoTemplate.save(pcpart);
			return pcpart;
		} catch (Exception e) {
			
			return null;
		}
	}


	@Override
	public List<Motherboard> findByMotherboardPartByName(String partName) {
		try {
			
			if(partName.equals("all")) {
				return mongoTemplate.findAll(Motherboard.class);
			}
			else {
				Query query = new Query();
				query.addCriteria(Criteria.where("name").is(partName));
				
				return mongoTemplate.find(query, Motherboard.class);
			}
			
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Motherboard findByMotherboardPartById(String id) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			
			return mongoTemplate.findOne(query, Motherboard.class);
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<Motherboard> findMotherboardVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.find(query, Motherboard.class);
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Motherboard saveMotherboard(Motherboard pcpart) {
		try {
			mongoTemplate.save(pcpart);
			return pcpart;
		} catch (Exception e) {
			
			return null;
		}
	}


	@Override
	public List<Hard_disk> findByHard_diskPartByName(String partName) {
		try {
			
			if(partName.equals("all")) {
				return mongoTemplate.findAll(Hard_disk.class);
			}
			else {
				Query query = new Query();
				query.addCriteria(Criteria.where("name").is(partName));
				
				return mongoTemplate.find(query, Hard_disk.class);
			}
			
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Hard_disk findByHard_diskPartById(String id) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			
			return mongoTemplate.findOne(query, Hard_disk.class);
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<Hard_disk> findHard_diskVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.find(query, Hard_disk.class);
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Hard_disk saveHard_disk(Hard_disk pcpart) {
		try {
			mongoTemplate.save(pcpart);
			return pcpart;
		} catch (Exception e) {
			
			return null;
		}
	}


	@Override
	public List<Ram> findBygetRamParts() {
		try {
			
			return mongoTemplate.findAll(Ram.class);
			
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<User> getVendorsForProduct(String category, String pro_name) {
		try {
			Query query = new Query();
			Query query_user = new Query();
			query.addCriteria(Criteria.where("name").is(pro_name));
			Ram ram = null;
			Vga vga = null;
			Motherboard motherboard = null;
			Cpu cpu = null;
			Hard_disk hard_disk = null;
			if(category.equals("ram")) {
				ram =  (Ram) mongoTemplate.find(query, Ram.class);
				query_user.addCriteria(Criteria.where("name").is(ram.getOwner()));
			}
			else if(category.equals("vga")) {
				vga =  (Vga) mongoTemplate.find(query, Vga.class);
				query_user.addCriteria(Criteria.where("name").is(vga.getOwner()));
			}
			else if(category.equals("motherboard")) {
				motherboard =  (Motherboard) mongoTemplate.find(query, Motherboard.class);
				query_user.addCriteria(Criteria.where("name").is(motherboard.getOwner()));
			}
			else if(category.equals("cpu")) {
				cpu =  (Cpu) mongoTemplate.find(query, Cpu.class);
				query_user.addCriteria(Criteria.where("name").is(cpu.getOwner()));
			}
			else if(category.equals("hard_disk")) {
				hard_disk =  (Hard_disk) mongoTemplate.find(query, Hard_disk.class);
				query_user.addCriteria(Criteria.where("name").is(hard_disk.getOwner()));
			}
			return mongoTemplate.find(query_user, User.class);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Notification pushNotification(Notification notification) {
		try {
			mongoTemplate.save(notification);
			return notification;
		} catch (Exception e) {
			
			return null;
		}
		
	}


	@Override
	public Notification checkNotification(String user_id, String product) {

		try {
			Query query = new Query();
			Query query_user = new Query();
			query_user.addCriteria(Criteria.where("ObjectId").is(user_id));
			User user = (User) mongoTemplate.find(query_user, User.class);
			
			query.addCriteria(Criteria.where("email").is(user.getEmail()).andOperator(Criteria.where("product").is(product)));
			Notification result = mongoTemplate.findOne(query, Notification.class);
			return result;
		} catch(Exception e) {
			return null;
		}
	}

}
