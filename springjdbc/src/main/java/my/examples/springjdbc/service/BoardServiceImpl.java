package my.examples.springjdbc.service;

import my.examples.springjdbc.dao.BoardDao;
import my.examples.springjdbc.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;

    @Override
    @Transactional(readOnly = true)
    public List<Board> selectAllBoards(int start, int limit) {
        return boardDao.selectAllBoards(0,5);
    }

    @Override
    @Transactional(readOnly = true)
    public Board selectBoard(Long id) {
        return boardDao.selectBoard(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> searchBoards(String option, String keyword) {
        return boardDao.searchBoards(option,keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public int selectAllCount() {
        return boardDao.selectAllCount();
    }

    @Override
    @Transactional(readOnly = true)
    public long selectSearchCount(String subject, String keyword) {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public long getTotalPage(int boardCount, int list) {
        return boardDao.getTotalPage(boardCount,list);
    }

    @Override
    @Transactional
    public long addBoard(Board board) {
        return boardDao.addBoard(board);
    }

    @Override
    public long updateBoard(Long id, String title, String content) {
        return boardDao.updateBoard(id,title,content);
    }

    @Override
    public long deleteBoard(Long id) {
        return boardDao.deleteBoard(id);
    }
}
