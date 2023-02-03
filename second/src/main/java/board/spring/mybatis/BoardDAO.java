package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
	BoardDTO getOneBoard(int seq);
	void updateViewCount(int seq);
	void insertBoard(BoardDTO dto);
}
