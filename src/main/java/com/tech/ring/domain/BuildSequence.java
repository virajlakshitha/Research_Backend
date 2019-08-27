package com.tech.ring.domain;

public class BuildSequence {
	private Ram ram;
	
	private Vga vga;
	
	private Cpu cpu;
	
	private Motherboard motherboard;
	
	private Hard_disk hard_disk;

	public BuildSequence(Ram ram, Vga vga, Cpu cpu, Motherboard motherboard, Hard_disk hard_disk) {
		
		this.ram = ram;
		this.vga = vga;
		this.cpu = cpu;
		this.motherboard = motherboard;
		this.hard_disk = hard_disk;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Vga getVga() {
		return vga;
	}

	public void setVga(Vga vga) {
		this.vga = vga;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	public Hard_disk getHard_disk() {
		return hard_disk;
	}

	public void setHard_disk(Hard_disk hard_disk) {
		this.hard_disk = hard_disk;
	}
}
