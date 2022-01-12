package com.teamcloud.teamcloud.controller;

import com.teamcloud.teamcloud.domain.TeamBoard;
import com.teamcloud.teamcloud.repository.BoardRepository;
import com.teamcloud.teamcloud.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    private final BoardRepository boardRepository;

    @Autowired
    public BoardController(BoardService boardService, BoardRepository boardRepository) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

    /*
     * 게시글 목록
     */
    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }

    /*
     * 게시글 상세 및 등록 폼 호출
     */
    @GetMapping({"", "/"})
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long bdno, Model model) {
        model.addAttribute("board", boardService.findBoardByBdno(bdno));
        return "/board/form";
    }

    /*
     * 게시글 생성
     */
    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody TeamBoard board) {
        board.setRegdate(LocalDateTime.now());
        board.setUpdatedDate(LocalDateTime.now());
        boardRepository.save(board);

        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    /*
     * 게시글 수정
     */
    @PutMapping("/{bdno}")
    public ResponseEntity<?> putBoard(@PathVariable("bdno") Long bdno, @RequestBody TeamBoard board) {
        TeamBoard updateBoard = boardRepository.getOne(bdno);
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContents(board.getContents());
        updateBoard.setUpdatedDate(LocalDateTime.now());
        boardRepository.save(updateBoard);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    /*
     * 게시글 삭제
     */
    @DeleteMapping("/{bdno}")
    public ResponseEntity<?> deleteBoard(@PathVariable("bdno") Long bdno) {
        boardRepository.deleteByBdno(bdno);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


}
