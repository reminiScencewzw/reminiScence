package cn.yunhe.controller;

import java.util.List;

import cn.yunhe.entity.Motif;
import cn.yunhe.service.IMotifService;
import cn.yunhe.service.impl.MotifServiceImpl;

public class MotifController {

	IMotifService motifService = new MotifServiceImpl();

	public List<Motif> queryMotifList() {
		return motifService.queryMotifList();
	}

	public Motif queryMotifById(int id) {
		return motifService.queryMotifById(id);
	}

	public int delMotifById(String state, int id) {
		return motifService.delMotifById(state, id);
	}

	public int addMotif(Motif motif) {
		return motifService.addMotif(motif);
	}

	public int getCount() {
		return motifService.getCount();
	}

	public List<Motif> queryMotifList(int pageCount, int pageIndex) {
		return motifService.queryMotifList(pageCount, pageIndex);
	}

	public int changeMotifName(int id, String name) {

		return motifService.changeMotifName(id, name);
	}
}
