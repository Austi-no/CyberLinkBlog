package com.austine.blog.service;

import com.austine.blog.Dto.PostDto;
import com.austine.blog.MessageUtil.ApiResponse;
import com.austine.blog.MessageUtil.CustomMessages;
import com.austine.blog.model.Category;
import com.austine.blog.model.Post;
import com.austine.blog.repository.CategoryRepository;
import com.austine.blog.repository.PageRepository;
import com.austine.blog.repository.PostRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Transactional
@Service
public class AppService {

    @Autowired
    private PostRespository postRespository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PageRepository pageRepository;





    public ResponseEntity saveSupplyOrder( @RequestParam("image") MultipartFile file, @RequestParam ("postDto") String postDto)throws IOException {


        if (postDto == null) {
        }
        PostDto newPost=new ObjectMapper().readValue(postDto, PostDto.class);
        newPost.setImage(file.getBytes());Optional<Category> categoryName = categoryRepository.findByCategoryName(newPost.getCategoryId());

        Post post = new Post();

        post.setCategoryId(categoryName.get());
        post.setDateCreated(new Date());
        post.setDescription(newPost.getDescription());
        post.setImage(file.getBytes());
        post.setSlug(newPost.getSlug());
        post.setTitle(newPost.getTitle());
        post.setExcerpt(newPost.getExcerpt());
        post.setImageName(file.getOriginalFilename());
        return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Success, postRespository.save(post)));
    }







    public PostRespository getPostRespository() {
        return postRespository;
    }

    public void setPostRespository(PostRespository postRespository) {
        this.postRespository = postRespository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public PageRepository getPageRepository() {
        return pageRepository;
    }

    public void setPageRepository(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }
}
