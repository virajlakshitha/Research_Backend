package com.tech.ring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;

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
			
			return null;
		}
	}
	

	@Override
	public Ram findByRamPartByName(String partName) {

		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(partName));
			
			return mongoTemplate.findOne(query, Ram.class);
			
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
	public Ram findRamVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("owner").is(part_name));
			
			return mongoTemplate.findOne(query, Ram.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Vga findByVgaPartByName(String partName) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(partName));
			
			return mongoTemplate.findOne(query, Vga.class);
			
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
	public Vga findVgaVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.findOne(query, Vga.class);
			
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
	public Cpu findByCpuPartByName(String partName) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(partName));
			
			return mongoTemplate.findOne(query, Cpu.class);
			
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
	public Cpu findCpuVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.findOne(query, Cpu.class);
			
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
	public Motherboard findByMotherboardPartByName(String partName) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(partName));
			
			return mongoTemplate.findOne(query, Motherboard.class);
			
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
	public Motherboard findMotherboardVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.findOne(query, Motherboard.class);
			
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
	public Hard_disk findByHard_diskPartByName(String partName) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(partName));
			
			return mongoTemplate.findOne(query, Hard_disk.class);
			
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
	public Hard_disk findHard_diskVendorPrices(String part_name) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(part_name));
			
			return mongoTemplate.findOne(query, Hard_disk.class);
			
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

}
